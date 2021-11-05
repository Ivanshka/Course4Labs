from plotly.figure_factory._dendrogram import sch
from sklearn.cluster import KMeans, AgglomerativeClustering
import matplotlib.pyplot as plt
import  pandas as pd


df= pd.read_csv("CSV/2017.csv")

X =df[["Happiness.Score","Freedom"]].values


plt.scatter(X[:,0],X[:,1], label='Our Data')
plt.show()


wcss = []
for i in range(1, 11):
   kmeans = KMeans(n_clusters = i, init = 'k-means++', random_state = 42)
   kmeans.fit(X)
   #appending the WCSS to the list (kmeans.inertia_ returns the WCSS value for an initialized cluster)
   wcss.append(kmeans.inertia_)


plt.plot(range(1, 11), wcss)
plt.title('The Elbow Point Graph')
plt.xlabel('Number of clusters')
plt.ylabel('WCSS')
plt.show()




#Fitting K-Means to the dataset
kmeans = KMeans(n_clusters = 6, init = 'k-means++')

#Returns a label for each data point based on the number of clusters
y = kmeans.fit_predict(X)
print(y)
print(f"{len(y)=}")



# Visualising the clusters
#Scatter plotting for (x,y) with label 1 as Cluster 1 in color c = red and points in size s = 50
plt.scatter(X[y == 0, 0], X[y == 0, 1], s = 50, c = 'red', label = 'Cluster 1')
#Scatter plotting for (x,y) with label 2 as Cluster 2 in color c = blue and points in size s = 50
plt.scatter(X[y == 1, 0], X[y == 1, 1], s = 50, c = 'blue', label = 'Cluster 2')
#Scatter plotting for (x,y) with label 3 as Cluster 3 in color c = green and points in size s = 50
plt.scatter(X[y == 2, 0], X[y == 2, 1], s = 50, c = 'green', label = 'Cluster 3')

plt.scatter(X[y == 3, 0], X[y == 3, 1], s = 50, c = 'yellow', label = 'Cluster 4')

plt.scatter(X[y == 4, 0], X[y == 4, 1], s = 50, c = 'black', label = 'Cluster 5')

plt.scatter(X[y == 5, 0], X[y == 5, 1], s = 50, c = 'purple', label = 'Cluster 6')

plt.scatter(X[100,0],X[100,1], s=500, marker='X', color='grey',label = 'One Value')

#Scatter plotting the centroids with label = 'Centroids' in color c = cyan and points in size s = 100
plt.scatter(kmeans.cluster_centers_[:, 0], kmeans.cluster_centers_[:, 1], s = 100, c = 'cyan', label = 'Centroids')

plt.title('Our Data')
plt.xlabel('Happiness.Score')
plt.ylabel('Freedom')
plt.legend()
plt.show()


dendrogram = sch.dendrogram(sch.linkage(X, method='ward'))
plt.show()

model = AgglomerativeClustering(n_clusters=6, affinity='euclidean', linkage='ward')
model.fit(X)
labels = model.labels_
plt.scatter(X[labels==0, 0], X[labels==0, 1], s=50, marker='o', color='red', label = 'Cluster 1')
plt.scatter(X[labels==1, 0], X[labels==1, 1], s=50, marker='o', color='blue', label = 'Cluster 2')
plt.scatter(X[labels==2, 0], X[labels==2, 1], s=50, marker='o', color='green', label = 'Cluster 3')
plt.scatter(X[labels==3, 0], X[labels==3, 1], s=50, marker='o', color='yellow', label = 'Cluster 4')
plt.scatter(X[labels==4, 0], X[labels==4, 1], s=50, marker='o', color='black', label = 'Cluster 5')
plt.scatter(X[labels==5, 0], X[labels==5, 1], s=50, marker='o', color='purple', label = 'Cluster 6')
plt.scatter(X[100,0],X[100,1], s=500, marker='X', color='grey', label = 'One value')
plt.title('Our Data')
plt.xlabel('Happiness.Score')
plt.ylabel('Freedom')
plt.legend()
plt.show()