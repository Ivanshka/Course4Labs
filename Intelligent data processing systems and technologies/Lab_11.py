import time
import numpy as np
from matplotlib import pyplot as plt
from sklearn.datasets import load_digits
from sklearn.metrics import accuracy_score
from sklearn.model_selection import train_test_split
from sklearn import decomposition
from sklearn.tree import DecisionTreeClassifier

digists = load_digits()
print(digists.data.shape)

X = digists.data
y = digists.target

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=.3,
                                                    stratify=y,
                                                    random_state=42)

clf = DecisionTreeClassifier(max_depth=2,random_state=42)
st=time.time_ns()
clf.fit(X_train, y_train)
print("Time passed(nanoseconds):----%.2f----"%(time.time_ns()-st))
preds = clf.predict_proba(X_test)
print('Accuracy: {:.5f}'.format(accuracy_score(y_test,preds.argmax(axis=1))))



pca = decomposition.PCA(n_components=64)
X_centered = X - X.mean(axis=0)
pca.fit(X_centered)
X_pca = pca.transform(X_centered)
X_train, X_test, y_train, y_test = train_test_split(X_pca, y, test_size=.3,
                                                    stratify=y,
                                                    random_state=42)
for i, component in enumerate(pca.components_):
    print("{} component: {}% of initial variance".format(i + 1,
          round(100 * pca.explained_variance_ratio_[i], 2)))
    print(" + ".join("%.3f x %s" % (value, name)
                     for value, name in zip(component,
                                            digists.feature_names)))
print(pca.explained_variance_ratio_)
print(np.cumsum(pca.explained_variance_ratio_))

pca = decomposition.PCA(n_components=2)
X_centered = X - X.mean(axis=0)
pca.fit(X_centered)
X_pca = pca.transform(X_centered)
X_train, X_test, y_train, y_test = train_test_split(X_pca, y, test_size=.3,
                                                    stratify=y,
                                                    random_state=42)
clf = DecisionTreeClassifier(max_depth=2, random_state=42)
st1=time.time_ns()
clf.fit(X_train, y_train)
preds = clf.predict_proba(X_test)
print(print("Time passed(nanoseconds):----%.2f----"%(time.time_ns()-st1)))
print('Accuracy: {:.5f}'.format(accuracy_score(y_test,
                                                preds.argmax(axis=1))))


pca = decomposition.PCA(n_components=64)
X_centered = X - X.mean(axis=0)
pca.fit(X_centered)
plt.figure(figsize=(10, 7))
plt.plot(np.cumsum(pca.explained_variance_ratio_), color='b', lw=2)
plt.xlabel('Number of components')
plt.ylabel('Total explained variance')
plt.xlim(0, 65)
plt.yticks(np.arange(0, 1.1, 0.1))
plt.axhline(0.97, c='r')
plt.show();

pca = decomposition.PCA(n_components=30)
X_centered = X - X.mean(axis=0)
st2=time.time_ns()
pca.fit(X_centered)
print("Time passed(nanoseconds):----%.2f----"%(time.time_ns()-st2))
X_pca = pca.transform(X_centered)
X_train, X_test, y_train, y_test = train_test_split(X_pca, y, test_size=.3,
                                                    stratify=y,
                                                    random_state=42)

clf = DecisionTreeClassifier(max_depth=2, random_state=42)
clf.fit(X_train, y_train)
preds = clf.predict_proba(X_test)
print('Accuracy: {:.5f}'.format(accuracy_score(y_test,
                                                preds.argmax(axis=1))))