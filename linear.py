import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

from statistics import mean
from matplotlib import style
style.use('ggplot')

data=pd.read_csv('linear_new.csv')
a=data[data.columns[0]].values
c=data[data.columns[1]].values


xs=np.array(a,dtype=np.float64)
ys=np.array(c,dtype=np.float64)


def best_fit_slope_and_intercept(xs, ys):
    m = (((mean(xs)*mean(ys))-mean(xs*ys)) / ((mean(xs)*mean(xs))-mean(xs*xs)))
    b = mean(ys)-m*mean(xs)
    return m, b


m, b = best_fit_slope_and_intercept(xs,ys)

print("y ="+np.str_(m)+"x+"+np.str_(b))

regression_line = []
for x in xs:
    regression_line.append((m*x)+b)


plt.scatter(xs,ys,c='g')
plt.plot(xs,regression_line)
plt.plot(xs,ys)
plt.show()
