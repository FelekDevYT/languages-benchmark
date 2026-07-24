import (
    "fmt",
    "os",
    "strconv"
)

func main() {
    n, _ := strconv.ParseInt(os.Args[1], 10, 64)
    m, _ := strconv.ParseInt(os.Args[2], 10, 64)
    var counter int64 = 1

    for i := int64(1); i < n; i++ {
        for j := int64(1); j < m; j++ {
            counter += i * j
        }
    }
    fmt.Println(counter)
}