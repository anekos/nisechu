
.PHONY: clean

target/nise-chu:
	lein bin
	~/script/dev/clojure/fix-lein-bin-classpath ./target/nise-chu

clean:
	lein clean
