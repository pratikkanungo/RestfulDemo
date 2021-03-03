#!/usr/bin/env bash
sudo apt-get update
echo "Installing Git.."
sudo apt-get install -y git
echo "Installing Maven.."
sudo apt-get purge maven maven2 maven3
sudo apt-add-repository ppa:andrei-pozolotin/maven3
sudo apt-get update
sudo apt-get install maven3
sudo apt-get install -y software-properties-common python-software-properties
echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | sudo /usr/bin/debconf-set-selections
echo "Installing Java 8.."
#sudo add-apt-repository -y ppa:webupd8team/java
#sudo apt-get update
#sudo apt-get install -y oracle-java8-installer
#echo "Setting environment variables for Java 8.."
#sudo apt-get install -y oracle-java8-set-default
#export MAVEN_OPTS='-Xmx512m -XX:MaxPermSize=128m'
sudo add-apt-repository ppa:openjdk-r/ppa
sudo apt-get update
sudo apt-get install openjdk-8-jdk
sudo update-alternatives --config java
sudo update-alternatives --config javac
git clone https://github.com/pratikkanungo/RestfulDemo.git
cd RestfulDemo
mvn spring-boot:run