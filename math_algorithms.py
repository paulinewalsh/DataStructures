

# Euclid's formula states that, given an arbitrary pair of integers m and n, with m > n > 0,
# a pythagorean triple will be formed when a=m^2-n^2, b = 2mn, and c = m^2 + n^2
def euclid(m, n):
	a = m**2 - n**2
	b = 2*m*n
	c = m**2 + n**2
	return (a,b,c)

def find_pythagorean_triple(x):
	n = 1

	while n < x:
		m = n + 1
		while m < x:
			triplet = euclid(m, n)
			if sum(triplet) == x:
				break
			m +=1
		if sum(triplet) == x:
			break
		n += 1

	a = triplet[0]
	b = triplet[1]
	c = triplet[2]

	valid = (a**2 + b**2 == c**2)

	if valid:
		return triplet
	return None
	


def main():
	x = 1000
	triplet = find_pythagorean_triple(x)
	if triplet:
		print("The pythagorean triple where a + b + c = " + str(x) + " is " + str(triplet))
	else:
		print("No valid triplet which sums to " + str(x))

	


if __name__ == '__main__':
    main()
