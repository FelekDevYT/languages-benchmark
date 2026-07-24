const std = @import("std");

pub fn main() !void {
    const args = try std.process.argsAlloc(std.heap.page_allocator);
    defer std.process.argsFree(std.heap.page_allocator, args);

    const N = try std.fmt.parseInt(i64, args[1], 10);
    const M = try std.fmt.parseInt(i64, args[2], 10);

    var counter: i64 = 1;
    var i: i64 = 1;
    while (i < N) : (i += 1) {
        var j: i64 = 1;
        while (j < M) : (j += 1) {
            counter += i * j;
        }
    }

    std.debug.print("{d}\n", .{counter});
}