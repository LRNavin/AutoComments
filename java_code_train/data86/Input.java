public void emit(final SpannableStringBuilder VAR0,final Block VAR1){
  VAR1.removeSurroundingEmptyLines();
switch (VAR1.type) {
case NONE:
    break;
case PARAGRAPH:
  this.config.decorator.openParagraph(VAR0);
break;
case BLOCKQUOTE:
this.config.decorator.openBlockquote(VAR0);
break;
case UNORDERED_LIST:
this.config.decorator.openUnorderedList(VAR0);
break;
case ORDERED_LIST:
this.config.decorator.openOrderedList(VAR0);
break;
case UNORDERED_LIST_ITEM:
this.config.decorator.openUnOrderedListItem(VAR0);
break;
case ORDERED_LIST_ITEM:
this.config.decorator.openOrderedListItem(VAR0);
break;
}
if (VAR1.hasLines()) {
this.emitLines(VAR0,VAR1);
}
 else {
Block block=VAR1.blocks;
while (block != null) {
this.emit(VAR0,block);
block=block.next;
}
}
switch (VAR1.type) {
case NONE:
break;
case PARAGRAPH:
this.config.decorator.closeParagraph(VAR0);
break;
case BLOCKQUOTE:
this.config.decorator.closeBlockquote(VAR0);
break;
case UNORDERED_LIST:
this.config.decorator.closeUnorderedList(VAR0);
break;
case ORDERED_LIST:
this.config.decorator.closeOrderedList(VAR0);
break;
case UNORDERED_LIST_ITEM:
this.config.decorator.closeUnOrderedListItem(VAR0);
break;
case ORDERED_LIST_ITEM:
this.config.decorator.closeOrderedListItem(VAR0);
break;
}
}
