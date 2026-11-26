package org.jabref.gui.groups;

import java.util.List;

import org.jabref.gui.icon.IconTheme;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GroupIconPickerItemsTest {

    @Test
    void multiStarRatingIconsAreExcluded() {
        List<GroupDialogView.GroupIconPickerItem> items = GroupDialogView.GroupIconPickerItems.ALL;

        List<String> identifiers = items.stream()
                                        .map(GroupDialogView.GroupIconPickerItem::persistedIdentifier)
                                        .toList();

        assertFalse(identifiers.contains(IconTheme.JabRefIcons.RANK1.name()));
        assertFalse(identifiers.contains(IconTheme.JabRefIcons.RANK2.name()));
        assertFalse(identifiers.contains(IconTheme.JabRefIcons.RANK3.name()));
        assertFalse(identifiers.contains(IconTheme.JabRefIcons.RANK4.name()));
        assertFalse(identifiers.contains(IconTheme.JabRefIcons.RANK5.name()));

        assertTrue(identifiers.contains(IconTheme.JabRefIcons.FOLDER.name()));
    }
}
