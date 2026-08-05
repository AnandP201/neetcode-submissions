

type Item struct {
    node int
    weight int
    index int
}

type PriorityQueue []*Item

func (pq PriorityQueue) Len()int{
    return len(pq)
}

func (pq PriorityQueue) Less(i,j int)bool {
    // min-heap
    return pq[i].weight < pq[j].weight
}

func (pq PriorityQueue) Swap(i,j int){
    pq[i],pq[j]=pq[j],pq[i]
    
    pq[i].index = i
    pq[j].index=j
}

func (pq *PriorityQueue) Push(x any){
    n := len(*pq)

    item := x.(*Item)

    item.index = n 
    *pq = append(*pq,item)
}

func (pq *PriorityQueue) Pop()any{
    
    old := *pq

    // len of slice
    n := len(old)
    item := old[n-1]

    // pointing last item to out of slice
    item.index=-1
    // memory free for gc
    old[n-1]=nil
    
    // re-form slice from 0 -> n-1 ( n-1 excluded )
    *pq = old[0:n-1]
    return item
}


func networkDelayTime(times [][]int, n int, k int) int {

	graph := make(map[int][][]int,0)

	for i:=0;i<=n;i++{
		graph[i]=make([][]int,0)
	}

	for _, time := range times {
		u := time[0]
		v := time[1]
		w := time[2]
		
		graph[u]=append(graph[u],[]int{v,w})
	}

    pq := make(PriorityQueue,0,n)
    heap.Init(&pq)

    heap.Push(&pq,&Item{
        node : k,
        weight : 0,
    })

    // cost array
    cost := make([]int,n+1)
    for i:= range len(cost){
        cost[i]=math.MaxInt
    }
    cost[k]=0

    for pq.Len() > 0 {

        item := heap.Pop(&pq).(*Item)

        u := item.node
        wt := item.weight

        if wt > cost[u] {
            continue
        }

        // go to neighbor
        for _, neighbor := range graph[u] {
            v := neighbor[0]
            dv := neighbor[1]

            dist := dv + wt

            if dist >= cost[v]{
                // If to reach v , I need more cost than cost[v], then it's not optimal
                continue
            }
            cost[v]=dist
            heap.Push(&pq,&Item{
                node : v,
                weight : dist,
            })
        }

      
        
    }

      val := math.MinInt

        for i :=1 ;i<len(cost);i++ {
            val = max(val,cost[i])
        }

        if val == math.MaxInt {
            return -1
        }

        return val
    
    

}
