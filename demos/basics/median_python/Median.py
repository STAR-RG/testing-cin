
def median (a, b, c):
    med = c
    if (b < c):
        if (a < b):
            med = b
        elif (a < c):
            med = a
    else:
        if (a > b):
            med = b
        elif (a > c):
            med = a

    return med

print median(1, 3, 4)
print median(-1, -1, -1)
