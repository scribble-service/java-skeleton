from xml.etree import ElementTree as et

ns = "http://maven.apache.org/POM/4.0.0"
et.register_namespace('', ns)
tree = et.ElementTree()
tree.parse('pom.xml')

version_tree_element = tree.getroot().find("{%s}version" % ns)

print(version_tree_element.text)