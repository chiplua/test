CC=gcc
all: test print_execl
test:
	$(CC) -g -o signal_test signal_test.c  inotify_test.c event_queue.c
print_execl:
	$(CC) -g -o ./bin/print_execl print_execl.c


