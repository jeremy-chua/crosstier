
This is a sample that has vulnerabilities spanning multiple application 
technologies (Java, PL/SQL, JSP, struts).

To run the sample, change to this directory in a command prompt or shell
window and run the following commands:

$ sourceanalyzer -b crosstier -clean
$ sourceanalyzer -b crosstier -classpath lib/struts.jar .
$ sourceanalyzer -b crosstier -scan -f crosstier.fpr

View the results using Audit Workbench:

$ auditworkbench crosstier.fpr

The output should contain several issues of different types, including
two Access Control vulnerabilities. One of these is a cross-tier result. It
has a dataflow trace from user input in Java code that can affect a
SELECT statement in PL/SQL. The "External Entries" section in the
dataflow trace indicates that user input came from line 3 in my.jsp
and is passed to the action located at http://host/app/myAction.do.
