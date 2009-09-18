#!/bin/bash
rm *.class; javac SchSimpleTerminal.java; java -Djavax.net.ssl.trustStore=mySrvKeystore -Djavax.net.ssl.trustStorePassword=123456 SchSimpleTerminal
