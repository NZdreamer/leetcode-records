"""
Level 1
The editor starts with a blank text document, with the cursor at initial position 0.
1. APPEND <text> should append the inputted string text to the document starting from the current position of the cursor. After the operation, the cursor should be at the end of the added string.
queries = [
    ["APPEND", "Hey"],               | "" -> "Hey"
    ["APPEND", " there"],            | "Hey" -> "Hey there"
    ["APPEND", "!"]                  | "Hey there" -> "Hey there!"
]
// returns: [ "Hey",
//            "Hey there",
//            "Hey there!" ]
2. MOVE <position> should move the cursor to the specified position. The cursor should be positioned between document characters, and are enumerated sequentially starting from 0. If the specified position is out of bounds, then move the cursor to the nearest available position.
queries = [
    ["APPEND", "Hey you"],           | "" -> "Hey you"
    ["MOVE", "3"],                   | moves the cursor after the first "y"
    ["APPEND", ","]                  | "Hey you" -> "Hey, you"
]
// returns: [ "Hey you",
//            "Hey you",
//            "Hey, you" ]
3. BACKSPACE should remove the character right before the cursor, if any.
queries = [
    [APPEND", "Hey you"],            | "" -> "Hey you"
    ["BACKSPACE"],                   | "Hey you" -> "Hey yo"
    ["BACKSPACE"]                    | "Hey yo" -> "Hey y"
]
// returns: [ "Hey you",
//            "Hey yo",
//            "Hey y" ]
and
queries = [
    ["APPEND", "!"],                 | "" -> "!"
    ["BACKSPACE"],                   | "!" -> ""
    ["BACKSPACE"]                    | "" -> ""
]
// returns: [ "!",
//            "",
//            "" ]
Level 2
Introduce methods to copy a part of the document text.
4. SELECT <left> <right> should select the text between the left and right cursor positions. Selection borders should be returned to the bounds of the document. 
If the selection is empty, it becomes a cursor position. Any modification operation replace the selected text and places the cursor at the end of the modified segment.
For example, the following operations
queries = [
    ["APPEND", "Hello cruel world!"],  | "" -> "Hello cruel world!"
    ["SELECT", "5", "11"],             | selects " cruel"
    ["APPEND", ","]                    | "Hello cruel world!" -> "Hello, world!"
]
// returns: [ "Hello cruel world!",
//            "Hello cruel world!",
//            "Hello, world!" ]
produce "Hello, world!" with the cursor positioned after the comma.
SELECT and APPEND should replace the selected characters with the appended characters:
queries = [
    ["APPEND", "Hello"],               | "" -> "Hello"        
    ["SELECT", "2", "5"],              | Selects a substring "llo"
    ["APPEND", "y there"]              | "Hello" -> "Hey there"
]
// returns: [ "Hello",
//            "Hello",
//            "Hey there" ]
5. COPY should copy the selected text to the clipboard, if there is an active non-empty selection. The current selected text (if any) remains selected after the operation.
6. PASTE should append the text from the clipboard. The current selected text (if any) remains selected after the operation.
For example, the following operations
queries = [
    ["APPEND", "Hello, world!"],       | "" -> "Hello, world!"
    ["SELECT", "5", "12"],             | selects ", world"
    ["COPY"],                          | copies ", world"
    ["MOVE", "12"],                    | moves the cursor to after "d"
    ["PASTE"],                         | "Hello, world!" -> "Hello, world, world!"
    ["PASTE"]                          | "Hello, world, world!" -> "Hello, world, world, world!"
]
// returns: [ "Hello, world!",
//            "Hello, world!",
//            "Hello, world!",
//            "Hello, world!",
//            "Hello, world, world!",
//            "Hello, world, world, world!" ]
Level 3
The text editor should allow document changes to be tracked and reverted. Consider only operations that actually modify the contents of the text document, which are (APPEND, BACKSPACE, PASTE, UNDO, and REDO).
7. UNDO should restore the document to the state before the previous modification or REDO operation. The selection and cursor position should be also restored.
For example,
queries = [
    ["APPEND", "Hello, world!"],       | "" -> "Hello, world!"
    ["SELECT", "7", "12"],             | selects "world"
    ["BACKSPACE"],                     | "Hello, world!" -> "Hello, !"
    ["UNDO"],                          | restores "Hello, world!" with "world" selected
    ["APPEND", "you"]                  | "Hello, world!" -> "Hello, you!"
]
// returns: [ "Hello, world!",
//            "Hello, world!",
//            "Hello, !",
//            "Hello, world!",
//            "Hello, you!" ]
8. REDO can only be performed if the document has not been modified since the last UNDO operation. REDO should restore the state before the previous UNDO operation, including the selection and cursor position. Multiple UNDO and REDO operations can be performed in a row.
For example,
queries = [
    ["APPEND", "Hello, world!"],       | "" -> "Hello, world!"
    ["SELECT", "7", "12"],             | selects "world"
    ["BACKSPACE"],                     | "Hello, world!" -> "Hello, !"
    ["MOVE", "6"],                     | moves the cursor to after the comma
    ["UNDO"],                          | restores "Hello, world!" with "world" selected
    ["UNDO"],                          | restores initial ""
    ["REDO"],                          | restores "Hello, world!" with "world" selected
    ["REDO"]                           | restores "Hello, !" with the cursor after the comma
]
// returns: [ "Hello, world!",
//            "Hello, world!",
//            "Hello, !",
//            "Hello, !",
//            "Hello, world!",
//            "",
//            "Hello, world!",
//            "Hello, !" ]
Level 4
The text editor should support multiple text documents with a common clipboard.
9. CREATE <name> should create a blank text document name. If such a file already exists, ignore the operation and return empty string. Modification history is stored individually for each document.
10. SWITCH <name> should switch the current document to name. If there is no such file, ignore the operation and return empty string. 
When switching to a file, the position of the cursor and selection should return to the state in which they were left.
Note: it is guaranteed that all operations from previous levels will be executed on the active document. For backward compatibility, assume for Levels 1-3 there is a single, initially active document.
For example,
queries = [
    ["CREATE", "document1"],       | creates document1
    ["CREATE", "document2"],       | creates document2
    ["CREATE", "document1"],       | ignores the operation
    ["SWITCH", "document1"],       | switches to document1
    ["APPEND", "Hello, world!"],   | document1: "" -> "Hello, world!"
    ["SELECT", "7", "12"],         | selects "world"
    ["COPY"],                      | copies "world" to the clipboard
    ["SWITCH", "document2"],       | switches to document2
    ["PASTE"],                     | document2: "" -> "world"
    ["SWITCH", "document1"],       | switches to document1
    ["BACKSPACE"]                  | document1: "Hello, world!" -> "Hello, !"
]
// returns: [ "",
//            "",
//            "",
//            "",
//            "Hello, world!",
//            "Hello,          world!",
//            "Hello, world!",
//            "",
//            "world",
//            "Hello, world!",
//            "Hello, !" ]
Example
For
queries = [
    ["APPEND", "Hey"],
    ["APPEND", " you"],
    ["APPEND", ", don't"],
    ["APPEND", " "],
    ["APPEND", "let me down"]
]
the output should be
textEditor2_2(queries) = [
    "Hey",
    "Hey you",
    "Hey you, don't",
    "Hey you, don't ",
    "Hey you, don't let me down"
]
"""

 
class State:
    def __init__(self, cursor, selected_length, content):
        self.cursor = cursor
        self.selected_length = selected_length
        self.content = content

class TextEditor:
    def __init__(self, text_editor_mgr):
        self.content = []
        self.cursor = 0
        self.selected_length = 0
        self.undo_stack = []
        self.prev_state_stack = []
        self.text_editor_mgr = text_editor_mgr
        
    def append(self, input):
        if input == "":
            return ''.join(self.content)
            
        self.save_cur_state()
        self.clear_undo_stack()
        start = self.cursor - self.selected_length
        self.content = self.content[:start] + list(input) + self.content[self.cursor:]
        self.cursor = start + len(input)
        self.selected_length = 0
        return ''.join(self.content)
        
    def delete(self):
        start = self.cursor - self.selected_length
        if not self.content:
            self.cursor = 0
            return ''.join(self.content)
            
        if start == self.cursor and self.cursor >= len(self.content):
            self.selected_length = 0
            return ''.join(self.content)
            
        self.save_cur_state()
        self.clear_undo_stack()
        if start == self.cursor:
            self.content.pop(self.cursor)
        else:
            del self.content[start: self.cursor]
            self.cursor = start
            
        if self.cursor < 0:
            self.cursor = 0
        self.selected_length = 0
        return ''.join(self.content)
        
    def cut(self):
        if self.selected_length == 0:
            return ''.join(self.content)
            
        self.text_editor_mgr.shared_clipboard = ''.join(self.content[self.cursor - self.selected_length: self.cursor])
        return self.delete()
    
    def paste(self):
        return self.append(self.text_editor_mgr.shared_clipboard)
    
    def move(self, position):
        position = int(position)
        self.selected_length = 0
        if position <= 0:
            self.cursor = 0
            return ''.join(self.content)
            
        self.cursor = position   
        if self.cursor > len(self.content):
            self.cursor = len(self.content)
            return ''.join(self.content)
        
        return ''.join(self.content)
        
    def select(self, p1, p2):
        p1 = int(p1)
        p2 = int(p2)
        lower = max(0, min(p1, p2))
        upper = min(len(self.content), max(p1, p2))
        
        self.cursor = upper
        self.selected_length = upper - lower
        return ''.join(self.content)
        
    def undo(self):
        if not self.prev_state_stack:
            self.content = []
            self.cursor = 0
            self.selected_length = 0
            return ''.join(self.content)
        
        cur_state = State(self.cursor, self.selected_length, self.content[::])
        self.undo_stack.append(cur_state)
        prev_state = self.prev_state_stack.pop()
        self.content = prev_state.content[::]
        self.selected_length = prev_state.selected_length
        self.cursor = prev_state.cursor
        
        return ''.join(self.content)
        
    def redo(self):
        if not self.undo_stack:
            return ''.join(self.content)
        
        self.prev_state_stack.append(State(self.cursor, self.selected_length, self.content[::]))
        before_undo = self.undo_stack.pop()
        self.content = before_undo.content[::]
        self.cursor = before_undo.cursor
        self.selected_length = before_undo.selected_length
        return ''.join(self.content)
        
    def save_cur_state(self):
        self.prev_state_stack.append(State(self.cursor, self.selected_length, self.content[::]))
        
    def clear_undo_stack(self):
        self.undo_stack = []
        
    def close(self):
        self.selected_length = 0
        self.cursor = len(self.content)
        self.prev_state_stack = []
        self.undo_stack = []
        
class TextEditorManager:
    def __init__(self):
        self.shared_clipboard = ""
        self.text_editor_map = {}
        self.active_text_editor_stack = []
        
    def create(self, name):
        if name in self.text_editor_map:
            return ''
        
        text_editor = TextEditor(self)
        self.text_editor_map[name] = text_editor
        
        active_text_editor = self.get_cur_active_text_editor()
        if active_text_editor:
            return ''.join(active_text_editor.content)
        
        return ''
        
    def switch(self, name):
        if name not in self.text_editor_map:
            return ''
        
        text_editor = self.text_editor_map[name]
        self.active_text_editor_stack.append(text_editor)
        return ''.join(text_editor.content)
        
    def close(self):
        text_editor = self.active_text_editor_stack.pop()
        text_editor.close()
        
    def get_cur_active_text_editor(self):
        if self.active_text_editor_stack:
            return self.active_text_editor_stack[-1]

def solution(queries):
    mgr = TextEditorManager()
    mgr.create('doc')
    mgr.switch('doc')
    result = []
    for query in queries:
        text_editor = mgr.get_cur_active_text_editor()
        res = ""
        if query[0] == 'APPEND':
            res = text_editor.append(query[1])
        elif query[0] == 'MOVE':
            res = text_editor.move(query[1])
        elif query[0] == 'DELETE':
            res = text_editor.delete()
        elif query[0] == 'SELECT':
            res = text_editor.select(query[1], query[2])
        elif query[0] == 'UNDO':
            res = text_editor.undo()
        elif query[0] == 'REDO':
            res = text_editor.redo()
        elif query[0] == 'CUT':
            res = text_editor.cut()
        elif query[0] == 'PASTE':
            res = text_editor.paste()
        elif query[0] == "CREATE":
            res = mgr.create(query[1])
        elif query[0] == 'SWITCH':
            res = mgr.switch(query[1])
        
        result.append(res)
    
    return result
        


# queries = [["APPEND", "Hey"], ["APPEND", " there"], ["APPEND", "!"]]
# queries = [["APPEND", "Hey you"],["MOVE", "3"],["APPEND", ","]]
# queries = [["APPEND", "Hey you"],["BACKSPACE"],["BACKSPACE"]]
# queries = [["APPEND", "!"], ["BACKSPACE"],["BACKSPACE"]] 
# queries = [["APPEND", "Hello, world!"], ["SELECT", "5", "12"],["COPY"],["MOVE", "12"], ["PASTE"],["PASTE"]]
# queries = [["APPEND","Hello, world!"],["SELECT","7","12"],["BACKSPACE"],["UNDO"],["APPEND","you"]]
# queries = [["APPEND", "Hello, world!"],["SELECT", "7", "12"],["BACKSPACE"],["MOVE", "6"],["UNDO"],["UNDO"],["REDO"],["REDO"]]
queries = [["CREATE", "document1"],["CREATE", "document2"],["CREATE", "document1"],["SWITCH", "document1"],["APPEND", "Hello, world!"],["SELECT", "7", "12"],["COPY"],["SWITCH", "document2"],["PASTE"],["SWITCH", "document1"],["BACKSPACE"]]


queries = [["APPEND", "text generated by AI that will conquer the world!!!"],["SELECT", "0", "17"],["BACKSPACE"],["UNDO"],["APPEND", "hello,"]]

# mgr = TextEditorManager()
# mgr.open('doc')
# for query in queries:
#     text_editor = mgr.get_cur_active_text_editor()
#     res = ""
#     if query[0] == 'APPEND':
#         res = text_editor.append(query[1])
#     elif query[0] == 'MOVE':
#         res = text_editor.move(query[1])
#     elif query[0] == 'BACKSPACE':
#         res = text_editor.delete()
#     elif query[0] == 'SELECT':
#         res = text_editor.select(query[1], query[2])
#     elif query[0] == 'UNDO':
#         res = text_editor.undo()
#     elif query[0] == 'REDO':
#         res = text_editor.redo()
#     elif query[0] == 'CUT':
#         res = text_editor.cut()
#     elif query[0] == 'PASTE':
#         res = text_editor.paste()
#     elif query[0] == 'CREATE':
#         res = mgr.open(query[1])
#     elif query[0] == 'SWITCH':
#         res = mgr.open(query[1])
    
#     print(res)



    
    
    
    
        

