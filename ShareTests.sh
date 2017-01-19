cd //home/jmthomse/cpe103
mkdir -p $(find . -name "*Tests.java" -exec dirname ~/www/Tests/{} \;)
find . -name *Tests.java -exec ln {} ~/www/Tests/{} \;
chmod 755 -R ~/www/Tests
