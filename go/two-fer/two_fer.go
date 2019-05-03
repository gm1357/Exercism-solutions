// Package twofer contains a string manipulation function
package twofer

import "fmt"

// ShareWith returns two-fer string
func ShareWith(name string) string {
	if name == "" {
		name = "you"
	}

	return fmt.Sprintf("One for %s, one for me.", name)
}
