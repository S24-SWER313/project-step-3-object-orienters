#bin/bash
for dir in */; do
    if [ "$dir" != "src/" ]; then
      mvn clean install -f ./"$dir"
    fi
    echo "$dir"
done