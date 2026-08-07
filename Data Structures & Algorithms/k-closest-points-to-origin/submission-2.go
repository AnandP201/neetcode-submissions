type PriorityQueue [][]int

func(pq PriorityQueue)Len()int{
	return len(pq)
}

func(pq PriorityQueue)Less(i,j int)bool{
	return squaredDistance(pq[i]) > squaredDistance(pq[j])  
}

func(pq PriorityQueue)Swap(i,j int) {
	pq[i],pq[j]=pq[j],pq[i]
}

func(pq *PriorityQueue)Push(x any){
	*pq = append(*pq, x.([]int))
}

func(pq *PriorityQueue)Pop()any{
	old := *pq
	n := len(old)
	item := old[n-1]
	*pq = old[0 : n-1]
	return item
}

func squaredDistance(p[]int) int {
	return p[0]*p[0] + p[1]*p[1]
}

func kClosest(points [][]int, k int) [][]int {

	pq := make(PriorityQueue,0,k+1)

	heap.Init(&pq)

	for _, point := range points {
		
		heap.Push(&pq,point)

		if len(pq)>k {
			heap.Pop(&pq)
		}
	}

	ans := make([][]int,k)

	for i := 0; i < k; i++ {
		ans[i] = heap.Pop(&pq).([]int)
	}

	return ans

}
