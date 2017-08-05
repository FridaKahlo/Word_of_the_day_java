Overview
--------


This program is an experiment in Java to download the word of the day and its image from dexonline

Requirements
============

- Connect to ``dexonline.ro`` over http
- Get the url for today's word
- Access that url and use ``xpath`` to extract:

	- the link to the image
	- the word of the day
	- the definition of the word
	
- Store these in a local ``SQLite`` database
