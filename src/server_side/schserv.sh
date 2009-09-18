#!/bin/bash
rm *.class;javac SchServerMain.java 
java -Djavax.net.ssl.keyStore=mySrvKeystore -Djavax.net.ssl.keyStorePassword=123456 SchServerMain

