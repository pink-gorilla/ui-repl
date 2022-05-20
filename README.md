# ui-repl [![GitHub Actions status |pink-gorilla/ui-repl](https://github.com/pink-gorilla/ui-repl/workflows/CI/badge.svg)](https://github.com/pink-gorilla/ui-repl/actions?workflow=CI)[![Clojars Project](https://img.shields.io/clojars/v/org.pinkgorilla/ui-repl.svg)](https://clojars.org/org.pinkgorilla/ui-repl)

useful REPL (clj + cljs) functions

This functions are not in goldly (which provides cljs kernel) or nrepl-middleware (which provides clj kernel).
This functions are not many, but if they are included in the kernels, it is more difficult to
test and fine tune the functions.

## End-Users
- this project is NOT for you! Instead go to:
- [goldly](https://github.com/pink-gorilla/goldly)

## Demo

The demo is just for developers to see that all the functions in this module work as intended.

```
clj -X:goldly
```

To compile js and run:
```
clj -X:goldly:build :profile "npm-install"
clj -X:goldly:build :profile "compile2"
clj -X:goldly
```

## tools.deps.alpha - addlib test

`clj -M:test-addlib`




