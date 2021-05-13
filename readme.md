**Graph-0.**
Web service takes text input in the format shown and returns a JSON tree structure.
"Home" is first vertex in list by default.  "id" is zero-based.

**Example 1: JSON representation of Graph**
This:
`http://localhost:8080/graph/getjson/A,B;B,C;A,C;B,D;C,D;D,E;F,G;G,H;F,H`
...gives you this:

`{
"id" : 0,
"home" : "A",
"edges" : [ {
"id" : 0,
"start" : "A",
"end" : "B"
}, {
"id" : 1,
"start" : "B",
"end" : "C"
}, {
"id" : 2,
"start" : "A",
"end" : "C"
}, {
"id" : 3,
"start" : "B",
"end" : "D"
}, {
"id" : 4,
"start" : "C",
"end" : "D"
}, {
"id" : 5,
"start" : "D",
"end" : "E"
}, {
"id" : 6,
"start" : "F",
"end" : "G"
}, {
"id" : 7,
"start" : "G",
"end" : "H"
}, {
"id" : 8,
"start" : "F",
"end" : "H"
} ]
}`

This:
`http://localhost:8080/graph/getjson/apple,pear;apple,orange;orange,egg;orange,banana;apple,grapefruit`
...gives you this:

`{
"id" : 0,
"home" : "apple",
"edges" : [ {
"id" : 0,
"start" : "apple",
"end" : "pear"
}, {
"id" : 1,
"start" : "apple",
"end" : "orange"
}, {
"id" : 2,
"start" : "orange",
"end" : "egg"
}, {
"id" : 3,
"start" : "orange",
"end" : "banana"
}, {
"id" : 4,
"start" : "apple",
"end" : "grapefruit"
} ]
}`


**Example 1: JSON representation of Adjacency Matrix**
This:
`http://localhost:8080/graph/matrix/A,B;B,C;A,C;B,D;C,D;D,E;F,G;G,H;F,H`
...gives you this:

`{
"rows" : [ "A", "B", "C", "D", "E", "F", "G", "H" ],
"cols" : [ "A", "B", "C", "D", "E", "F", "G", "H" ],
"matrix" : [ [ 0, 1, 1, 0, 0, 0, 0, 0 ], [ 0, 0, 1, 1, 0, 0, 0, 0 ], [ 0, 0, 0, 1, 0, 0, 0, 0 ], [ 0, 0, 0, 0, 1, 0, 0, 0 ], [ 0, 0, 0, 0, 0, 0, 0, 0 ], [ 0, 0, 0, 0, 0, 0, 1, 1 ], [ 0, 0, 0, 0, 0, 0, 0, 1 ], [ 0, 0, 0, 0, 0, 0, 0, 0 ] ]
}`

This:
`http://localhost:8080/graph/matrix/apple,pear;apple,orange;orange,egg;orange,banana;apple,grapefruit`
...gives you this:

`{
"rows" : [ "apple", "pear", "orange", "egg", "banana", "grapefruit" ],
"cols" : [ "apple", "pear", "orange", "egg", "banana", "grapefruit" ],
"matrix" : [ [ 0, 1, 1, 0, 0, 1 ], [ 0, 0, 0, 0, 0, 0 ], [ 0, 0, 0, 1, 1, 0 ], [ 0, 0, 0, 0, 0, 0 ], [ 0, 0, 0, 0, 0, 0 ], [ 0, 0, 0, 0, 0, 0 ] ]
}`



More later.
