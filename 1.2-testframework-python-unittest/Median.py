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
