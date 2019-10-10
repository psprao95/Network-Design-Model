data <- read.csv(file="/users/psprao/eclipse-workspace/network-design-model/output1.csv")

# Getting K, cost and density  data
k<-data[,1]
cost<-data[,2]
density<-data[,3]

# Scatterplot of K vs Cost of Network
plot(k,cost,xlab="K",ylab="Cost ",main="Scatterplot: K vs Cost of Network")
lines(k,cost)

# Scatterplot of K vs Density of Network
plot(k,density,xlab="K",ylab="Density ",main="Scatterplot: K vs Density of Network")
lines(k,density)