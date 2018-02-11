/*
 * jQuery Easing v1.3 - http://gsgd.co.uk/sandbox/jquery/easing/
 *
 * Uses the built in easing capabilities added In jQuery 1.1
 * to offer multiple easing options
 *
 * TERMS OF USE - jQuery Easing
 *
 * Open source under the BSD License.
 *
 * Copyright © 2008 George McGinley Smith
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list of
 * conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list
 * of conditions and the following disclaimer in the documentation and/or other materials
 * provided with the distribution.
 *
 * Neither the name of the author nor the names of contributors may be used to endorse
 * or promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 *  COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 *  EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE
 *  GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

// t: current time, b: begInnIng value, c: change In value, d: duration
jQuery.easing['jswing'] = jQuery.easing['swing'];

jQuery.extend(jQuery.easing, {
  def: 'easeOutQuad',
  swing: function(x, t, b, c, d) {
    //alert(jQuery.easing.default);
    return jQuery.easing[jQuery.easing.def](x, t, b, c, d);
  },
  easeInQuad: function(x, t, b, c, d) {
    return c * (t /= d) * t + b;
  },
  easeOutQuad: function(x, t, b, c, d) {
    return -c * (t /= d) * (t - 2) + b;
  },
  easeInOutQuad: function(x, t, b, c, d) {
    if ((t /= d / 2) < 1) return c / 2 * t * t + b;
    return -c / 2 * ((--t) * (t - 2) - 1) + b;
  },
  easeInCubic: function(x, t, b, c, d) {
    return c * (t /= d) * t * t + b;
  },
  easeOutCubic: function(x, t, b, c, d) {
    return c * ((t = t / d - 1) * t * t + 1) + b;
  },
  easeInOutCubic: function(x, t, b, c, d) {
    if ((t /= d / 2) < 1) return c / 2 * t * t * t + b;
    return c / 2 * ((t -= 2) * t * t + 2) + b;
  },
  easeInQuart: function(x, t, b, c, d) {
    return c * (t /= d) * t * t * t + b;
  },
  easeOutQuart: function(x, t, b, c, d) {
    return -c * ((t = t / d - 1) * t * t * t - 1) + b;
  },
  easeInOutQuart: function(x, t, b, c, d) {
    if ((t /= d / 2) < 1) return c / 2 * t * t * t * t + b;
    return -c / 2 * ((t -= 2) * t * t * t - 2) + b;
  },
  easeInQuint: function(x, t, b, c, d) {
    return c * (t /= d) * t * t * t * t + b;
  },
  easeOutQuint: function(x, t, b, c, d) {
    return c * ((t = t / d - 1) * t * t * t * t + 1) + b;
  },
  easeInOutQuint: function(x, t, b, c, d) {
    if ((t /= d / 2) < 1) return c / 2 * t * t * t * t * t + b;
    return c / 2 * ((t -= 2) * t * t * t * t + 2) + b;
  },
  easeInSine: function(x, t, b, c, d) {
    return -c * Math.cos(t / d * (Math.PI / 2)) + c + b;
  },
  easeOutSine: function(x, t, b, c, d) {
    return c * Math.sin(t / d * (Math.PI / 2)) + b;
  },
  easeInOutSine: function(x, t, b, c, d) {
    return -c / 2 * (Math.cos(Math.PI * t / d) - 1) + b;
  },
  easeInExpo: function(x, t, b, c, d) {
    return (t == 0) ? b : c * Math.pow(2, 10 * (t / d - 1)) + b;
  },
  easeOutExpo: function(x, t, b, c, d) {
    return (t == d) ? b + c : c * (-Math.pow(2, -10 * t / d) + 1) + b;
  },
  easeInOutExpo: function(x, t, b, c, d) {
    if (t == 0) return b;
    if (t == d) return b + c;
    if ((t /= d / 2) < 1) return c / 2 * Math.pow(2, 10 * (t - 1)) + b;
    return c / 2 * (-Math.pow(2, -10 * --t) + 2) + b;
  },
  easeInCirc: function(x, t, b, c, d) {
    return -c * (Math.sqrt(1 - (t /= d) * t) - 1) + b;
  },
  easeOutCirc: function(x, t, b, c, d) {
    return c * Math.sqrt(1 - (t = t / d - 1) * t) + b;
  },
  easeInOutCirc: function(x, t, b, c, d) {
    if ((t /= d / 2) < 1) return -c / 2 * (Math.sqrt(1 - t * t) - 1) + b;
    return c / 2 * (Math.sqrt(1 - (t -= 2) * t) + 1) + b;
  },
  easeInElastic: function(x, t, b, c, d) {
    var s = 1.70158;
    var p = 0;
    var a = c;
    if (t == 0) return b;
    if ((t /= d) == 1) return b + c;
    if (!p) p = d * .3;
    if (a < Math.abs(c)) {
      a = c;
      var s = p / 4;
    } else var s = p / (2 * Math.PI) * Math.asin(c / a);
    return -(a * Math.pow(2, 10 * (t -= 1)) * Math.sin((t * d - s) * (2 * Math.PI) / p)) + b;
  },
  easeOutElastic: function(x, t, b, c, d) {
    var s = 1.70158;
    var p = 0;
    var a = c;
    if (t == 0) return b;
    if ((t /= d) == 1) return b + c;
    if (!p) p = d * .3;
    if (a < Math.abs(c)) {
      a = c;
      var s = p / 4;
    } else var s = p / (2 * Math.PI) * Math.asin(c / a);
    return a * Math.pow(2, -10 * t) * Math.sin((t * d - s) * (2 * Math.PI) / p) + c + b;
  },
  easeInOutElastic: function(x, t, b, c, d) {
    var s = 1.70158;
    var p = 0;
    var a = c;
    if (t == 0) return b;
    if ((t /= d / 2) == 2) return b + c;
    if (!p) p = d * (.3 * 1.5);
    if (a < Math.abs(c)) {
      a = c;
      var s = p / 4;
    } else var s = p / (2 * Math.PI) * Math.asin(c / a);
    if (t < 1) return -.5 * (a * Math.pow(2, 10 * (t -= 1)) * Math.sin((t * d - s) * (2 * Math.PI) / p)) + b;
    return a * Math.pow(2, -10 * (t -= 1)) * Math.sin((t * d - s) * (2 * Math.PI) / p) * .5 + c + b;
  },
  easeInBack: function(x, t, b, c, d, s) {
    if (s == undefined) s = 1.70158;
    return c * (t /= d) * t * ((s + 1) * t - s) + b;
  },
  easeOutBack: function(x, t, b, c, d, s) {
    if (s == undefined) s = 1.70158;
    return c * ((t = t / d - 1) * t * ((s + 1) * t + s) + 1) + b;
  },
  easeInOutBack: function(x, t, b, c, d, s) {
    if (s == undefined) s = 1.70158;
    if ((t /= d / 2) < 1) return c / 2 * (t * t * (((s *= (1.525)) + 1) * t - s)) + b;
    return c / 2 * ((t -= 2) * t * (((s *= (1.525)) + 1) * t + s) + 2) + b;
  },
  easeInBounce: function(x, t, b, c, d) {
    return c - jQuery.easing.easeOutBounce(x, d - t, 0, c, d) + b;
  },
  easeOutBounce: function(x, t, b, c, d) {
    if ((t /= d) < (1 / 2.75)) {
      return c * (7.5625 * t * t) + b;
    } else if (t < (2 / 2.75)) {
      return c * (7.5625 * (t -= (1.5 / 2.75)) * t + .75) + b;
    } else if (t < (2.5 / 2.75)) {
      return c * (7.5625 * (t -= (2.25 / 2.75)) * t + .9375) + b;
    } else {
      return c * (7.5625 * (t -= (2.625 / 2.75)) * t + .984375) + b;
    }
  },
  easeInOutBounce: function(x, t, b, c, d) {
    if (t < d / 2) return jQuery.easing.easeInBounce(x, t * 2, 0, c, d) * .5 + b;
    return jQuery.easing.easeOutBounce(x, t * 2 - d, 0, c, d) * .5 + c * .5 + b;
  }
});

/*
 *
 * TERMS OF USE - EASING EQUATIONS
 *
 * Open source under the BSD License.
 *
 * Copyright © 2001 Robert Penner
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list of
 * conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list
 * of conditions and the following disclaimer in the documentation and/or other materials
 * provided with the distribution.
 *
 * Neither the name of the author nor the names of contributors may be used to endorse
 * or promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 *  COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 *  EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE
 *  GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */


/**
 * jQuery accordions.js v0.1
 * 弹出框功能实现 - 选项卡切换
 */
(function($) {

  $.ui = $.ui || {};

  $.fn.extend({
    accordion: function(options, data) {
      var args = Array.prototype.slice.call(arguments, 1);
      return this.each(function() {
        if (typeof options == 'string') {
          var accordion = $.data(this, 'ui-tab');
          if (accordion && accordion[options]) {
            accordion[options].apply(accordion, args);
          }
        } else if (!$(this).is('.ui-tab')) {
          $.data(this, 'ui-tab', new $.ui.accordion(this, options));
        }
      });
    }
  });

  $.ui.accordion = function(container, options) {
    var $this = $(container);
    var _this = this;
    var last_index = 0; // 记录上一次所选择的tab值
    $this.addClass('ui-tab');
    _this.options = options = $.extend({}, options);
    //默认合并不要这么写
    var opts = $.extend({
      childId: options.childId, //横方向内容展示父节点id, @可缺省
      zHeadClass: options.zHeadClass, //只用为纵方向选项卡参数
      zContClass: options.zContClass, //只用为纵方向选项卡参数
      chooseClass: options.chooseClass || 'on', //选项卡被选中样式
      linkA: false, //父节点下面的选中样式是否在a标签上
      events: options.events || 'click', //事件,默认点击事件
      easings: options.easings, //效果种类
      index: options.index || 1, //默认显示第几个标签
      autoPlay: options.autoPlay || false, //是否自动播放
      speed: options.speed || 3, //播放速度/秒
      moveTabAuto: false, //tab是否是可移动的，显示左右箭头
      afterTabSelect: null,// tab切换时候传入的方法
      lazyLoad: false//是否延迟加载
    }, options);

    var parentChilds; //父节点下面所有子节点
    var childsAll; //内容所有子节点
    var s = -1; //初始化标签的序号
    var _scrollObj; //定时对象
    var styleBoolean = (opts.zHeadClass == undefined); //判断是否纵向选项卡 - 横
    var easingBoolen = (opts.easings == undefined); //判断是否有动态效果 - 无效果
    var contHeight = 0; //纵向内容高度
    s += opts.index; //加上默认第几个显示的数量
    opts.speed = opts.speed * 1000;

    //检验数据合法性
    if (opts.index > len) {
      alert('index数值过大');
      return;
    } else if (opts.index <= 0) {
      alert('index数值过小');
      return;
    }

    //通过zHeadClass判断是否横向和竖向选项卡
    if (styleBoolean) { //横向
      parentChilds = $this.children();
      var childNewId = opts.childId == undefined ? $this.next() : opts.childId; //判断子切换节点为空或自己定义其他名字
      childsAll = $(childNewId).children();
    } else { //纵向
      parentChilds = $this.find(opts.zHeadClass);
      childsAll = $this.find(opts.zContClass);
      parentChilds.each(function(i) {
        $(this).attr('rel', i);
      });
    }

    var len = parentChilds.length; //标签的数量

    //初始化纵向内容框高度
    if (!styleBoolean) {
      contHeight = $this.height() - parentChilds.eq(0).outerHeight() * len; //+边框的高度
      childsAll.css('height', contHeight);
    }

    //标签和下面内容对应显示
    function showCont(n) {
      var childChose = childsAll.eq(n);
      last_index = n;
      if (easingBoolen) {
        childsAll.hide().eq(n).show();
      }
      if (styleBoolean) { //-横向
        var parentNewChild = opts.linkA ? $this.find('a') : parentChilds;
        parentNewChild.removeClass(opts.chooseClass).eq(n).addClass(opts.chooseClass);

        if (!easingBoolen) { //显示效果
          childsAll.slideUp().eq(n).slideDown({
            duration: 200,
            easing: opts.easings
          });
        }
      } else { //-纵向
        parentChilds.removeClass(opts.chooseClass).eq(n).addClass(opts.chooseClass);
        parentChilds.find('s').removeClass('on').eq(n).addClass('on'); //纵选项卡右侧小点图标切换

        if (!easingBoolen) { //显示效果
          if (n === 0) { //判断第一个显示效果
            childsAll.hide().eq(0).show({
              'height': contHeight
            }, {
              duration: 200,
              easing: opts.easings
            });
          } else {
            childsAll.hide({
              'height': 0
            }, {
              duration: 200,
              easing: opts.easings
            });
            childsAll.eq(n).show({
              'height': contHeight
            }, {
              duration: 200,
              easing: opts.easings
            });
          }
        }
      }

      if (typeof opts.afterTabSelect === "function") {
        opts.afterTabSelect(childChose, s);
      }

    }

    var accord_left = $("<div class=\"accord-left\" style=\"display: none;\"><i class=\"icon iconfont\">&#xe64b;</i></div>");
    var accord_right = $("<div class=\"accord-right\" style=\"display: none;\"><i class=\"icon iconfont\">&#xe64a;</i></div>");

    function getWidthInfos() {
      var widthInfo = {
        wrap_width: $this.width(),
        total_width: $this[0].scrollWidth,
        scroll_left: $this.scrollLeft()
      };

      return widthInfo;
    }

    function dealShowArrow() {
      var widthInfo = getWidthInfos();
      if (widthInfo.total_width > widthInfo.wrap_width) {
        accord_left.show();
        accord_right.show();
      } else {
        accord_left.hide();
        accord_right.hide();
      }
    }


    /*在这个方法里书写moveTabAuto*/
    function moveTabAuto() {
      //如果属性为false不尽兴任何处理
      if (!opts.moveTabAuto) {
        return;
      }
      var accord_wraper;

      //处理父节点
      if (!$this.parent().hasClass("accord-wraper")) {
        $this.wrap("<div class=\"accord-wraper\"></div>");
      }
      accord_wraper = $this.parent();

      //处理箭头

      accord_wraper.append(accord_left);
      accord_wraper.append(accord_right);

      //处理箭头事件
      var item_width = 120; //默认的标签的长度
      accord_left.on("click", function() {
        var wi = getWidthInfos(),
          minus_width = wi.total_width - wi.wrap_width,
          scroll_left_len;
        //在大于0的时候才有调的价值
        if (wi.scroll_left > 0) {
          if ((wi.scroll_left - item_width) > 0) {
            scroll_left_len = wi.scroll_left - item_width;
          } else {
            scroll_left_len = 0;
          }
          $this.scrollLeft(scroll_left_len);
        }
      });

      accord_right.on("click", function() {
        var wi = getWidthInfos(),
          minus_width = wi.total_width - wi.wrap_width,
          scroll_left_len;

        //小于证明还有调整的必要，大于等于就没有调整的必要
        if (wi.scroll_left < minus_width) {
          if ((wi.scroll_left + item_width) <= minus_width) {
            scroll_left_len = wi.scroll_left + item_width;
          } else {
            scroll_left_len = minus_width;
          }
          $this.scrollLeft(scroll_left_len);
        }

      });

      //窗口宽度变化的时候进行缩放
      $(window).on("resize", function() {
        dealShowArrow();
      });

      dealShowArrow();
    }

    //默认选中显示的标签
    if(!opts.lazyLoad) {
     showCont(opts.index - 1);
    }
    moveTabAuto();


    //标签效果切换
    parentChilds.bind(opts.events, function() {
      //传参控制效果是否有效
      var options = _this.options;
      if (!options.disabled && options.disabled != undefined) //非字符引用会显示undefined
        return false;

      //防止重复点击
      var t = 0;
      parentChilds.each(function(i) {
        if ($(this).hasClass(opts.chooseClass)) {
          t = $(this).attr('rel');
          if (undefined === t) {
            t = $(this).index();
          }
        }
        if ($(this).find('a').hasClass(opts.chooseClass)) {
          t = $(this).index();
        }
      });

      if (styleBoolean) {
        s = $(this).index(); //点击后改变s的值
      } else {
        s = parseInt($(this).attr('rel'));
      }
      if (t == s) return false;

      showCont(s);

    });

    //播放控制
    var autoControl = {
      init: function() {
        _this = this;
        _this.play();
        _this.binds();
      },
      slide: function(j) {
        s += j;
        s = s >= len ? 0 : s;
        showCont(s);
      },
      play: function() {
        _scrollObj = setInterval(function() {
          _this.slide(1);
        }, opts.speed);
      },
      stop: function() {
        clearInterval(_scrollObj);
      },
      binds: function() {
        $this.bind('mouseover', function() {
          _this.stop();
        });
        $this.bind('mouseout', function() {
          _this.play();
        });
        $(childNewId).bind('mouseover', function() {
          _this.stop();
        });
        $(childNewId).bind('mouseout', function() {
          _this.play();
        });
      }
    };

    //判断是否自动播放
    if (opts.autoPlay) {
      autoControl.init();
    }


    /*在这里统一暴露方法*/
    return {
      enable: function() {
        _this.options.disabled = true;
      },
      disable: function() {
        _this.options.disabled = false;
      },
      //当用于弹窗或者隐藏元素身上的时候。。一些需要计算的属性需要重新计算重新layOut计算
      layoutTab: function() {
        dealShowArrow();
      },
      showCont: function(index) {
        if(!(typeof index === 'number' && index >= 0)) {
          index =  last_index;
        }
        showCont(index);
      }
    };

  };



  /*控制选项卡操作，起效与无效等
  $.ui.accordion.prototype = {
    enable: function() {
      this.options.disabled = true;
    },
    disable: function() {
      this.options.disabled = false;
    },
    //当用于弹窗或者隐藏元素身上的时候。。一些需要计算的属性需要重新计算重新layOut计算
    layoutTab: function () {
      dealShowArrow();
    }
  };*/

})(jQuery);
