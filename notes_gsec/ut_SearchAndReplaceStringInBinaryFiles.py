import os
import sys

# recursively search the path, replaces bytes in the files
def searchAndReplaceStringInBinaryFile(pathWithoutTrailingSystemSeparator:str, searchStr:str, newStr:str):
    # guard
    cwd:str = os.getcwd()
    folder = cwd.split(os.sep)[1]
    sandboxName = 'volatile' 
    # if ('volatile' in os.getcwd()) is False:
    if not(sandboxName in os.getcwd()): 
        print('use with cautious, run only inside a sandbox')
        return
    else: 
        print(os.getcwd())

    # trim()
    thisPath = pathWithoutTrailingSystemSeparator.strip()

    searchBytes = bytes(searchStr, 'utf-8')
    newBytes = bytes(newStr, 'utf-8')

    # guard
    tailChar = thisPath[-1]
    if tailChar == os.sep or tailChar == '\\' or tailChar =='/':
        print('trailing separator detected, aborting')
        return

    # recursion
    if os.path.isdir(thisPath):
        # ls 'dirName'
        children = os.listdir(thisPath)
        for child in children:
            childPath = thisPath + os.sep + child
            searchAndReplaceStringInBinaryFile(childPath, searchStr, newStr)
    else: # not dictionary
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

# searchAndReplaceStringInBinaryFile('./test/volatile.txt', 'anhzcvhasrdnveozxcioenv12345', 'anhzcvhasrdnveozxcioenv12346')

path_no_trailing_OSSep = sys.argv[1]
search_str = sys.argv[2]
replace_str = sys.argv[3]

# the entry, path or filename need to include the string "volatile"
searchAndReplaceStringInBinaryFile(path_no_trailing_OSSep, search_str, replace_str)
