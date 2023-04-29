import sys
from xml.etree import ElementTree as et

def validate_version_structure(version):
    if len(version) != 3:
        sys.exit('Invalid version structure')

    for i in version:
        if not i.isdigit():
            sys.exit('Version should contain only numbers.')

ns = "http://maven.apache.org/POM/4.0.0"
et.register_namespace('', ns)
tree = et.ElementTree()
tree.parse('pom.xml')

version_tree_element = tree.getroot().find("{%s}version" % ns)

version = version_tree_element.text.split(".")
validate_version_structure(version)

version[2] = str(int(version[2]) + 1)

version_tree_element.text = ".".join(version)

tree.write("pom.xml")