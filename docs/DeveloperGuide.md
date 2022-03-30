# Developer Guide

## Acknowledgements

{list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to the original source as well}

## Design
{Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}
### Good Class
#### Description
The goods class keeps track of the various inventory that will be input into the system through the commands class.
The diagram below shows the model component of the orderline class.
![Good Class Diagram](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/AY2122S2-CS2113T-T09-4/tp/master/docs/diagrams/Good.puml)

The Goods class allows for the creation of orderline objects which has the following attributes: id, name, quantity and 
description. Each attribute can be obtained using public get methods, and the attribute quantity can be set using the public set method.


## Implementation
### Regex Class
#### Description
The Regex Class is created to simplify the use of regular expressions in Java.
![Regex Class Diagram](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/AY2122S2-CS2113T-T09-4/tp/master/docs/diagrams/Regex.puml)
The Class Diagram above shows the different variables and methods associated with the regex class.
This class takes in the regular expression as a string and the string to be matched in the class contructor, and stores the results
in the private variable `groupValues` which is a Hash Map where the key would be the capture group name and the value as the matched results.

#### Operation
![Regex Class Diagram](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/AY2122S2-CS2113T-T09-4/tp/master/docs/diagrams/RegexMatching.puml)
The above diagram shows the inner workings of how the Regex Class will work. Here are the steps taken by the Regex Class:
1. findMatch() called when instantiating groupValues variable
2. findGroups() called within findMatch() to find the capture group names within the regex string
3. regexMatching() will then be called within findMatch() which will use Java's base Pattern and Matcher Class, and returns a Matcher Object
4. findMatch() will then use the Matcher object to fill in the HashMap of <key, value> pair of <capture group name, regex matching>
5. findMatch() will then return the HashMap object to groupValues variable

#### Example of Usage
```
String regex = "id/(?<id>\\d*) n/(?<name>.*) q/(?<qty>\\d*) d/(?<desc>\\.*)";
Regex regexMatch = new Regex(userInput, regex);
HashMap<String, String> matches = regexMatch.getGroupValues();
String id = matches.get("id");
String name = matches.get("name");
String quantity = matches.get("qty");
String description = matches.get("desc");
```
### Commands Class
#### Description
The Commands Class is the class which contains all the available commands that can be used in the Simplst CLI application.
![Commands Class Diagram](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/AY2122S2-CS2113T-T09-4/tp/master/docs/diagrams/CommandsClass.puml)

More about how each feature is run can be seen in each of the methods that can be found below.

### View Good Method
#### Description
View Good belongs as part of the Commands Class. It is used when a user would like to know more information about an inventory item has an item id linked to it in the warehouse.

#### Operation
![View Good Sequence Diagram](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/AY2122S2-CS2113T-T09-4/tp/master/docs/diagrams/viewGood.puml)

The above sequence diagram shows the operation of how the view orderline method will be called.
1. The User input will be read by the User Interface Class
2. The User Interface Class will then match the command keyword `view`
3. The Regex Class will then be call to match the rest of the user's input to find the id required for retrieving information of the inverntory.
4. The User Interface Class will call the viewGood() method from the Commands Class
5. This method will retrieve information of an inventory item by searching through the userOrderlines array list for the corresponding id.
6. The information retrieved will then be formatted and returned to screen for the user the see the information.

### Add Goods Method
#### Description
Add Goods belongs as part of the Commands Class. It is used to add a Good Object into the Collection of Goods Objects currently in the Warehouse.

#### Operation
![Regex Class Diagram](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/AY2122S2-CS2113T-T09-4/tp/master/docs/diagrams/addGood.puml)
The above sequence diagram shows the operation of how the add goods method will be called. 
1. The User input will be read by the User Interface Class
2. The User Interface Class will then match the command keyword `add`
3. The Regex Class will then be call to match the rest of the user's input to find the necessary values required for the Good Class
4. Afterwards, the User Interface class will call addGoods() method from the Commands Class
5. This method will then call the constructor of the Good class, creating a new instance of the Good Object
6. The addGood() method will then add the Good to the Collections storing the Good Objects currently in the WareHouse

For more examples of how a user can use a command, refer to the [UserGuide](/UserGuide.md)

### Remove Goods Method
#### Description
Remove Goods belongs as part of the Commands Class. It is used to remove a certain amount of goods from the inventory.
#### Operation
![removeGood diagram](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/AY2122S2-CS2113T-T09-4/tp/master/docs/diagrams/removeGood.puml)
The above sequence diagram shows the operation of how the add goods method will be called.
1. The User input will be read by the User Interface Class
2. The User Interface Class will then match the command keyword `remove`
3. The Regex Class will then be called to match the rest of the user's input to find the values required to remove goods from the inventory.
4. Afterwards, the User Interface class will call removeGood() method from the Commands Class
5. This method will then reduce the quantity of a type of goods if the quantity input is not larger than the existing quantity. If the quantity input is the same as the existing quantity, the goods object will be removed from the inventory.
6. The UI will show a message of format
    > `quantity` `name` have been removed
to show that the operation is successful.

For more examples of how a user can use a command, refer to the [UserGuide](/UserGuide.md)

### List Goods or List Orders Method
#### Description
The list goods or list orders method belongs to the Warehouse Class. It is used to display the list of existing goods 
or existing orders in the warehouse to the User.

![List sequence Diagram](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/AY2122S2-CS2113T-T09-4/tp/master/docs/diagrams/List.puml)

The above sequence diagram shows the operation of how the list goods method will be called.

1. The User input will be read by the User Interface Class
2. The User Interface Class will the match the command keyword `list`
3. Together with the previous step, the User Interface Class will check the flag followed by `list`
   3.1 If the flag is `o/`, the User Interface Class will call the listOrders() method in the Warehouse class
      3.1.1 Lastly, the list of orders is printed to the command line.
   3.2 Else, if the flag is `g/`, the User Interface Class will call the listGoods() method in the Warehouse class
      3.2.1 Following that, the Warehouse class will call the getGoods() method on the Good class
      3.2.2 Lastly, the list of goods is printed to the command line.
### Total Goods Method
#### Description
Total Goods belongs as part of the Commands Class. It is used to show the total quantity of Goods Objects currently in the Warehouse.

#### Operation
![Regex Class Diagram](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/AY2122S2-CS2113T-T09-4/tp/master/docs/diagrams/totalGoods.puml)
The above sequence diagram shows the operation of how the add goods method will be called.
1. The User input will be read by the User Interface Class
2. The User Interface Class will then match the command keyword `total`
3. Afterwards, the User Interface class will call totalGoods() method from the Commands Class
4. This method will then iterate through orderLists and sum up each quantity of each Good object in each order.
5. The totalGoods() method will return an integer of the number of goods in the warehouse. 

For more examples of how a user can use a command, refer to the [UserGuide](/UserGuide.md)



## Product scope
### Target user profile

Target user profile: Warehouse Workers
* has a need to update the warehouse on current stock of goods
* has a need to view the details of specific goods
* can type fast
* is reasonably comfortable using CLI apps

Target user profile: Warehouse Managers



### Value proposition

A cheap, user-friendly Warehouse Management System with intuitive commands to improve efficiency.

## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|Warehouse Worker|Get the total number of goods in the warehouse|its less tiring to have to count the total number of goods in the warehouse|
|v1.0|Warehouse Worker|View the description of goods easily|it would be easier for stocktaking|
|v1.0|Warehouse Worker|Add inventory items to the items list|so that I can keep track of goods entering the warehouse|
|v1.0|Warehouse Worker|Remove inventory items from the items list|so that I can track whenever a orderline is not in the warehouse|
|v1.0|Warehouse Worker|Get a list of all the inventory currently in the warehouse|so that I can see all the items we have in the warehouse|
<!-- |v2.0|user|find a to-do item by name|locate a to-do without having to go through the entire list| -->

## Non-Functional Requirements

{Give non-functional requirements}

## Glossary

* *glossary item* - Definition

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
