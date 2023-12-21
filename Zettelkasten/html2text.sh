#!/bin/bash

html2text() {
    # Check if html2text is available
    if ! command -v html2text &> /dev/null ; then
        echo "html2text could not be found"
        exit 1
    fi

    if [[ -z $1 ]]; then
        echo "invalid argument provided."
        exit 1
    fi

    html_file=$1

     # Check if the file exists
     if [ ! -f "$html_file" ]; then
         echo "File not found: $html_file"
     fi

    # strip the .html extension
    base_name=$(basename "$html_file" .html)

    # convert to markdown

    # check if html2text was successful
    if command -v html2text -b 0 < "$html_file" > "${base_name}.md" ; then
        echo "Converted $html_file to ${base_name}.md"
    else
        echo "html2text failed for $html_file"
    fi
}
