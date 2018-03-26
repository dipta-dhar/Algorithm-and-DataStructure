from operator import itemgetter
 
def kruskal( nodes, edges ):
    forest = DisjointSet()
    mst = []
    for n in nodes:
        forest.add( n )
 
    sz = len(nodes) - 1
 
    for e in sorted( edges, key=itemgetter( 2 ) ):
        n1, n2, _ = e
        t1 = forest.find(n1)
        t2 = forest.find(n2)
        if t1 != t2:
            mst.append(e)
            sz -= 1
            if sz == 0:
                return mst
         
            forest.union(t1, t2)
 
 
#test   
 
nodes = list( "ABCDEFG" )
edges = [ ("A", "B", 7), ("A", "D", 5),
          ("B", "C", 8), ("B", "D", 9), ("B", "E", 7),
      ("C", "E", 5),
      ("D", "E", 15), ("D", "F", 6),
      ("E", "F", 8), ("E", "G", 9),
      ("F", "G", 11)]
         
print kruskal( nodes, edges )