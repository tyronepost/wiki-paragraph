# wiki-paragraph
After reviewing the spec, I knew I would need to make http requests and parse through an HTML document.  My first step was to find some third-party libraries that can do these things for me, so I can focus on application logic.  A google search turned up 

http://jsoup.org/

which could do both. 

After going over the documentation, I set up a couple of projects in eclipse, one for the source code, and one for the unit tests, and jumped right into coding.  I followed a TDD approach to working on the exercise, building the WikiParagraph class guided by the WikiParagraphTest unit test.  Once I was satisfied with this modules capabilities, I moved over to the Application class, which is the main entry point for the cli.  For this I through a quick main  method together utilizing the WikiParagraph class I created, and made incremental improvements, adding command line arg functionality, and replacing spaces with underscores.
