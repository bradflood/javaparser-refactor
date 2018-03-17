JavaParser Refactor
---

A tool to auto-refactor Java code.

The primary use case is a client blocked from moving to some target technology because the business logic is "trapped" in aging specifications.

JavaParser is used to parse Java source code and execute callbacks via the Visitor pattern

The visitors (i.e. ClassVisitor, MethodVisitor, etc) will modify code according the refactoring goal
