import numpy as np
import pandas as pd
from sklearn.cluster import KMeans

df=pd.DataFrame({'X':[0.1,0.15,0.08,0.16,0.2,0.25,0.24,0.3],
                 'Y':[0.6,0.71,0.9,0.85,0.3,0.5,0.1,0.2]})

xs=df['X'].values
ys=df['Y'].values
X=np.array(list(zip(xs,ys)))
print(X)


cx=np.array([0.1,0.3])
cy=np.array([0.6,0.2])
centroids = cx,cy
print(cx,cy)

plt.scatter(xs,ys,c='g')
plt.scatter(cx[0],cy[0],marker='*',s=200,c='r')
plt.scatter(cx[1],cy[1],marker='*',s=200,c='b')
plt.show()

regressor=KMeans(n_clusters=2)
regressor.fit(X)
label=regressor.labels_
print(label)

count=0

for i in range(len(label)):
    if(label[i]==1):
     count=count+1
        
print(count)

new_centorids=regressor.cluster_centers_

print(new_centorids[0])
print(new_centorids[1]) 
