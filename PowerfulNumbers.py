num = input()
while num != '0':
    total = 0
    for count in range(len(num)):
        total += int(num[count]) ** int((count + 1))
    if total == int(num):
        print(num, 'is a powerful number.')
    else:
        print(num, 'is not a powerful number.')
    num = input()
