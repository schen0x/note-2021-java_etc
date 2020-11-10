import os
import sys

# recursively search the path, replace bytes in the files
def searchAndReplaceStringInBinaryFile(pathWithoutTrailingSystemSeparator:str, searchStr:str, newStr:str):
    searchBytes = bytes(searchStr, 'utf-8')
    newBytes = bytes(newStr, 'utf-8')
    thisPath = pathWithoutTrailingSystemSeparator.strip() # trim()

    # guard path
    sandboxName = 'volatile' 
    if not(sandboxName in os.getcwd()): 
        print('use with cautious, run only inside a sandbox')
        return
    else: 
        print(os.getcwd())

    # guard trailing os.sep
    tailChar = thisPath[-1]
    if tailChar == os.sep or tailChar == '\\' or tailChar =='/':
        print('trailing separator detected, aborting')
        return

    # recursion
    if os.path.isdir(thisPath):
        children = os.listdir(thisPath) # e.g. ['fileA', 'fileB', 'folderA']
        for child in os.listdir(thisPath):
            childPath = thisPath + os.sep + child
            searchAndReplaceStringInBinaryFile(childPath, searchStr, newStr)
    else:
        with open(thisPath, 'rb+') as f:
            content = f.read()
            if searchBytes in content:
                newContent = content.replace(searchBytes, newBytes)
                # replace
                f.seek(0)
                f.write(newContent)
                f.truncate()
                print("process completed at: " + thisPath)
    return

# searchAndReplaceStringInBinaryFile('./test/volatile.txt', 'str_old', 'str_new')

path_no_trailing_OSSep = sys.argv[1]
search_str = sys.argv[2]
replace_str = sys.argv[3]

# the entry, path or filename need to include the string "volatile"
searchAndReplaceStringInBinaryFile(path_no_trailing_OSSep, search_str, replace_str)
