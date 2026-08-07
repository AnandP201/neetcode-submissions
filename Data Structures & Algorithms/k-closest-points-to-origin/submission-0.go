type Item struct {
	num int
	dist float64
	index int
}

type PriorityQueue []*Item

func(pq PriorityQueue)Len()int{
	return len(pq)
}

func(pq PriorityQueue)Less(i,j int)bool{
	return pq[i].dist > pq[j].dist 
}

func(pq PriorityQueue)Swap(i,j int) {
	pq[i],pq[j]=pq[j],pq[i]
	pq[i].index=i
	pq[j].index=j
}

func(pq *PriorityQueue)Push(x any){
	n := len(*pq)
	item := x.(*Item)
	item.index = n
	*pq=append(*pq,item)
}

func(pq *PriorityQueue)Pop()any{
	old := *pq
	n := len(old)
	item := old[n-1]

	old[n-1]=nil
	item.index = -1

	*pq = old[0:n-1]
	return item
}

func calc(x[]int , y []int) float64 {
	dx := float64(x[0]-y[0])
	dy := float64(x[1]-y[1])

	return math.Sqrt(math.Pow(dx,2)+math.Pow(dy,2))
}

func kClosest(points [][]int, k int) [][]int {

	pq := make(PriorityQueue,0,k)

	heap.Init(&pq)

	origin := []int{0,0}

	for idx, point := range points {
		heap.Push(&pq,&Item{
			num:idx,
			dist:calc(point,origin),
		})
		if len(pq)>k {
			heap.Pop(&pq)
		}
	}

	ans := make([][]int,0)

	for len(pq) > 0 {
		idx := heap.Pop(&pq).(*Item).num
		ans = append(ans,points[idx])
	}

	return ans

}
