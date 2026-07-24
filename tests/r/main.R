#!/usr/bin/env Rscript

args <- commandArgs(trailingOnly = TRUE)
N <- as.integer(args[1])
M <- as.integer(args[2])

counter <- 1L
for (i in 1:(N-1)) {
  for (j in 1:(M-1)) {
    counter <- counter + i * j
  }
}
cat(counter, "\n")