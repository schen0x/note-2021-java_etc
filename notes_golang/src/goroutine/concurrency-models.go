package main

type Task struct {
	url string
}

func main() {
	// Buffered channel
	ch := make(chan Task, 3)

	numWorkers := 10
	for i := 0; i < numWorkers; i++ {
		go worker(ch)
	}

	tasks := []Task{{url: "http://127.0.0.1"}, {url: "http://127.0.0.2"}}

	for _, task := range tasks {
		ch <- task
	}
}

func worker(ch <-chan Task) {
	for {
		task := <-ch
		processTask(task)
	}
}

func processTask(t Task) {}
