#import the packages
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

#Read dataset
dataset = pd.read_csv("knn.csv")
X = dataset.iloc[:, :-1].values
y = dataset.iloc[:, 2].values
plt.plot(X[:, 0], X[:, 1], 'ro')

#import KNeighborshood Classifier and create object of it
from sklearn.neighbors import KNeighborsClassifier
classifier = KNeighborsClassifier(n_neighbors=3)
classifier.fit(X, y)

#predict the class for the point(6,6)
X_test = np.array([6, 2])
print("type x - : ", type(X_test))
y_pred = classifier.predict([X_test])
print('General KNN', y_pred)

classifier = KNeighborsClassifier(n_neighbors=3, weights='distance')
classifier.fit(X, y)

#predict the class for the point(6,6)
X_test = np.array([6, 2])
y_pred = classifier.predict([X_test])
print('Distance Weighted KNN', y_pred)
