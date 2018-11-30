
set SRC_DIR=.
set DST_DIR=.

..\..\..\GoogleProtobuf\bin\protoc -I=%SRC_DIR% --java_out=%DST_DIR% %SRC_DIR%/addressbook.proto