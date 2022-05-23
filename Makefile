COMPILER=javac
FLAGS=
SOURCE_PATH=src
SOURCE_CODE=src/br/com/mrchat
BUILD_PATH=bin

clean:
	rm -rf $(BUILD_PATH)/

create_folder_build:
	mkdir $(BUILD_PATH)

compile_socket_chat:
	$(COMPILER) $(FLAGS) -d $(BUILD_PATH) -sourcepath $(SOURCE_PATH) \
		$(SOURCE_CODE)/AppServer.java $(SOURCE_CODE)/AppClient.java
