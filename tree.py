import numpy as np
import pandas as pd
import pydotplus

from sklearn.externals.six import StringIO
from sklearn.preprocessing import LabelEncoder
from sklearn.tree import DecisionTreeClassifier
from sklearn.tree import export_graphviz


data=pd.read_csv('ass4.csv')
x=data.iloc[:,:-1]
y=data.iloc[:,4]


le=LabelEncoder()
X=x.apply(le.fit_transform)
print(X)

Classifier=DecisionTreeClassifier()
Classifier.fit(X.iloc[:,0:4],y)

pred=np.array([2,2,0,1])
res=Classifier.predict([pred])
print("Row 8-"+res)

dot_data=StringIO()
export_graphviz(Classifier,out_file=dot_data,filled=True,rounded=True,special_characters=True)
graph=pydotplus.graph_from_dot_data(dot_data.getvalue())
graph.write_png('tree.png')
