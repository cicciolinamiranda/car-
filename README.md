# Car Catalog
Display car catalog contents, parses the JSON-formatted response and displays the data. The data consists
of a list of products that should be shown in a vertical scrolling list. 

![Alt Text](https://media.giphy.com/media/8OPiRwvkPKyFPc9XCr/giphy.gif)

## IDE used ##
Android Studio 2.3.1

## Project Structure ##

### client ###
Contains all HTTP request related process, POJOs, Exception Handler and JSon parser utility class.

### client.asynctask ###
Background operation classes for HTTP requests

### client.model ###
POJOs that represents every entity in the response of the API

### presenter ###
Presenter class per Activity. Each Presenter class contains the presentation logic of every activity or page.

### customview ###
Custom view that are essential for the UI features of the app

### adapter ###
Custom List View adapters

## Model-View-Presenter ##
Design pattern used on this app.

## SDK Version ##

### Targek SDK ###
26(Oreo)

### Minimum SDK ###
18(Jelly Bean)

