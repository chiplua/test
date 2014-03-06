#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <signal.h>
#include "inotify_test.h"
#include <ctype.h>
#include <dirent.h>
#include <unistd.h>

#define LOGTAG "chiplua"
#define LOG(fmt, ...) printf(LOGTAG ": " fmt "\n", __VA_ARGS__)
#define WATCH_PATH "/dev/bus/usb"

typedef struct watch_descriptor_info {
    struct watch_descriptor_info* next;
    struct watch_descriptor_info* prev;
    int wd;
    char path[32];
} watch_descriptor_info;
static watch_descriptor_info watch_list;
     
int keep_running = 1;
int wd;
char busname[32];     
char currentdir[128];

static void signal_handl(int signum)
{
	printf("This is the signal_handler function\n");
	//sleep(2);
}

static void window_change_handl(int signum)
{
	printf("Your terminal window have changed\n");
	//sleep(2);
}     

static void signal_test()
{
	if (signal(SIGINT, signal_handl) == SIG_IGN) {
		/* Reset to SIG_IGN (ignore) if that was the prior state */
	        signal(SIGINT, SIG_IGN);
	}

	if (signal(SIGWINCH, window_change_handl) == SIG_IGN) {
		/* Reset to SIG_IGN (ignore) if that was the prior state */
	        signal(SIGWINCH, SIG_IGN);
	}
}

static void strcmp_strncmp_test()
{
	char *strrecovery = "recovery";
	if( strcmp(strrecovery, "recovery") == 0){
		printf("strcmp They are=\n");
	} else {
		printf("strcmp They are>\n");
	}		

	if( strncmp(strrecovery, "recovery", sizeof("recovery")) == 0){
		printf("strncmp They are=\n");
	} else {
		printf("strncmp They are>\n");
	}		

}
     
static void logtag_test(void)
{
	
	LOG("%s", "This is test for LOG function very good");
}

static inline int bad_name(const char *name)
{
	while(*name){
		if(!isdigit(*name++))
			return 1;		     
	}	     
	return 0;	     
}
     
static int  inotify_test(void)
{
	int inotify_fd;
	DIR *director_watch;
	struct dirent *de;


	inotify_fd = open_inotify_fd();
	if (inotify_fd > 0) {
		/* We will need a place to enqueue inotify events,
		   this is needed because if you do not read events
		   fast enough, you will miss them. This queue is
		   probably too small if you are monitoring something
		   like a directory with a lot of files and the directory
		   is deleted.
		*/
		queue_t q;
		q = queue_create(128);

		/* This is the watch descriptor returned for each item we are
	           watching. A real application might keep these for some use
	           in the application. This sample only makes sure that none of
	           the watch descriptors is less than 0.
	        */


		/* Watch all events (IN_ALL_EVENTS) for the directories and
	           files passed in as arguments.
	           Read the article for why you might want to alter this for
	           more efficient inotify use in your app.
	        */
		int index;
		wd = 0;
		printf("\n");
		/* for (index = 1; (index < argc) && wd >= 0); index++) { */
		/* 	wd = watch_dir(inotify_fd, argv[index], IN_ALL_EVENTS); */
		/* } */

		director_watch = opendir(WATCH_PATH);
		if (director_watch == 0)
			return;
		while((de = readdir(director_watch)) != 0) {
			if(bad_name(de->d_name))
				   continue;
			snprintf(busname, sizeof busname, "%s/%s", WATCH_PATH, de->d_name);		  

			int wd = watch_dir(inotify_fd, busname, IN_DELETE | IN_CREATE);
			if (wd > 0){
				LOG("chiplua add %s", busname);
			}
			process_inotify_events(q, inotify_fd);
		}	     
		return 0;
	}
	
	/* wd = watch_dir(inotify_fd, WATCH_PATH, IN_DELETE | IN_CREATE); */
	/* if (wd > 0) { */
	/* 	/\* Wait for events and process them until a */
	/* 	   temination condition is detected. */
	/* 	*\/ */
	/* 	process_inotify_events(q, inotify_fd); */
	/* } */
	/* printf("\nTerminating\n"); */

	/* /\* Finish up by closing the fd, destroying the queue, */
	/*    and returning a proper code. */
	/* *\/ */
	/* close_inotify_fd(inotify_fd); */
	/*queue_destroy(q); */
	
}

static int link_list_test(void)
{
	watch_descriptor_info* info;
	info = calloc(1, sizeof(watch_descriptor_info));
	info->wd = wd;
	memset(info->path, 0 , sizeof(info->path));
	strncpy(info->path, busname, strlen(busname));
	//Add to list
	info->next = &watch_list;
	info->prev = watch_list.prev;
	info->prev->next = info;
	info->next->prev = info;
}

static void chdir_and_execl_test(void)
{
	int errornum;
	char *binname = "print_execl";
	char exe_bin[32];

	printf("Into the chdir_and_execl_test\n");
	getcwd(currentdir, sizeof(currentdir));
	//chdir(binpath);
	strcat(currentdir, "/bin/print_execl");
	printf("The currentdir = %s\n", currentdir);
	errornum = execl(currentdir, binname, NULL);
	printf("The errornum is %d and the currentdir=%s\n", errornum, currentdir);
}

int main(int argc, char **argv)
{
	/* This is the file descriptor for the inotify watch */     
	printf("into the main function\n");
	LOG("%s", "signal test");
	//signal_test();
	LOG("%s", "LOGTAG test");
	logtag_test();	
	LOG("%s", "strcmp_strncmp_test");
	strcmp_strncmp_test();
	LOG("%s", "inotify_test");
	//inotify_test();
	LOG("%s", "link_list_test");
	//link_list_test();
	LOG("%s", "chdir_and_execl_test");
	chdir_and_execl_test();
	//for (;;);
	return 0;
}
 
