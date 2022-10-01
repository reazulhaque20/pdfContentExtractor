// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2022 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.parser.examples.advanced_usage.extract_data_from_various_formats.one_note;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.*;
import com.groupdocs.parser.options.*;
import com.groupdocs.parser.exceptions.*;
import com.groupdocs.parser.examples.Constants;

/**
 * This example shows how to find a keyword in Microsoft OneNote section.
 **/
public class SearchTextByKeyword {
    public static void run() {
        // Create an instance of Parser class
        try (Parser parser = new Parser(Constants.SampleOne)) {
            // Search a keyword:
            Iterable<SearchResult> sr = parser.search("Age");

            // Iterate over search results
            for (SearchResult s : sr) {
                // Print an index and found text:
                System.out.println(String.format("At %d: %s", s.getPosition(), s.getText()));
            }
        }
    }
}
