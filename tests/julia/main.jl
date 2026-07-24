function main()
    N = parse(Int, ARGS[1])
    M = parse(Int, ARGS[2])
    counter = 1
    for i in 1:N-1
        for j in 1:M-1
            counter += i * j
        end
    end
    println(counter)
end

main()