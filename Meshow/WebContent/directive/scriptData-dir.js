var scriptDirective = ['$templateCache', function($templateCache) {
  return {
    restrict: 'E',
    terminal: true,
    compile: function(element, attr) {
      if (attr.type == 'text/ng-template') {
        var templateUrl = attr.id,
            text = element[0].text;
        $templateCache.put(templateUrl, text);
      }
    }
  };
}];