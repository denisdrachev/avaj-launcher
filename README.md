>find * -name "*.java" > sources.txt

>javac -sourcepath . @sources.txt

>java avaj/Application scenario.txt

>find . -name "*.class" -type f -delete