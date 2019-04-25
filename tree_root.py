import pandas as pd
import math

from sklearn.model_selection import train_test_split

ig1 = []


def IGfun(c, l):
    ig = []
    for x in range(len(c)):
        ig.append((c[x] / l) * math.log((c[x] / l), 2))
    class_ig = sum(ig)
    return -class_ig


df = pd.read_csv('play.csv')


def entropy(l, at, aig):
    entr = (at / l) * aig
    ig1.append(entr)


df1 = df.iloc[:, -1]
ply_list = df1.tolist()
cls_label_len = len(df1)

c = pd.value_counts(df.iloc[:, -1].values, sort=False)

classig = IGfun(c, cls_label_len)

labl = list(df)

lbl_len = len(labl) - 1
pl = df1.drop_duplicates().tolist()
ent = []
fent = []
for i in range(0, lbl_len):
    var = labl[i]
    slst = []
    vig = []
    vcnt = []
    slst = df[var].drop_duplicates().tolist()
    for j in range(0, len(slst)):
        n_cnt = 0
        y_cnt = 0
        ag = slst[j]

        for f, b in zip(df[var].tolist(), ply_list):
            if (f == ag):
                if (b == pl[0]):
                    n_cnt = n_cnt + 1
                if (b == pl[1]):
                    y_cnt = y_cnt + 1
        igfuncnt = []
        igfuncnt.append(n_cnt)
        igfuncnt.append(y_cnt)
        fcnt = n_cnt + y_cnt
        if n_cnt == 0 or y_cnt == 0:
            var_ig = 0
        else:
            var_ig = IGfun(igfuncnt, fcnt)

        vig.append(var_ig)
        vcnt.append(fcnt)
    for k in range(0, len(vig)):
        entropy(cls_label_len, vcnt[k], vig[k])

    fent.append(sum(ig1))
    ig1 = []

GainT = []
for m in range(len(fent)):
    gain = classig - fent[m]
    GainT.append(gain)

comp = GainT[0]
comp_i = 0
for i in range(0, len(GainT)):
    if (GainT[i] >= comp):
        comp = GainT[i]
        comp_i = i

print('root of tree is ' + labl[comp_i])
