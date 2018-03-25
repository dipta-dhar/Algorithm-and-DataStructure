def default_compare(a, b):
  if a < b:
    return -1
  elif a > b:
    return 1
  return 0

def sort(array, compare=default_compare):
  gap = len(array)
  shrinkFactor = 1.3
  swapped = False

  while gap > 1 or swapped:
    if gap > 1:
      gap = math.floor(gap / shrinkFactor)
    swapped = False
    for i in range(len(array) - gap):
      if compare(array[i], array[i + gap]) > 0:
        array[i], array[i + gap] = array[i + gap], array[i]
        swapped = True

  return array