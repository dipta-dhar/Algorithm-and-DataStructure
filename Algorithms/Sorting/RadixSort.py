def counting_sort(arr, max_value, get_index):
  counts = [0] * max_value

  # Counting - O(n)
  for a in arr:s
    counts[get_index(a)] += 1
  
  # Accumulating - O(k)
  for i, c in enumerate(counts):
    if i == 0:
      continue
    else:
      counts[i] += counts[i-1]

  # Calculating start index - O(k)
  for i, c in enumerate(counts[:-1]):
    if i == 0:
      counts[i] = 0
    counts[i+1] = c

  ret = [None] * len(arr)
  # Sorting - O(n)
  for a in arr:
    index = counts[get_index(a)]
    ret[index] = a
    counts[get_index(a)] += 1
  
  return ret